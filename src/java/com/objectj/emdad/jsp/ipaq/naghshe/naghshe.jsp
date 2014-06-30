<%@ page import="java.sql.*, java.util.*, java.io.*, java.util.zip.*, com.objectj.emdad.ejb.*,
                 com.objectj.emdad.web.util.*" %>
<%!
	static final String cur_dir = "/com/objectj/emdad/jsp/ipaq/naghshe/";
	static final int img_width = 220;
    private ImageMap readImages( javax.servlet.http.HttpServletRequest request ) throws Exception {
        ImageMap imgMap = new ImageMap();
		int azX = Integer.parseInt( request.getParameter( "azX" ) );
		int taX = Integer.parseInt( request.getParameter( "taX" ) );
		int azY = Integer.parseInt( request.getParameter( "azY" ) );
		int taY = Integer.parseInt( request.getParameter( "taY" ) );
        Connection c = com.objectj.emdad.ejb.util.Util.getConnection();
        ResultSet imgs = c.createStatement().executeQuery( "SELECT * FROM naghshe WHERE("+azX+" <= azTooleGoegraphy) AND ("+taX+" > azTooleGoegraphy) AND ("+azY+" < taArzeGoegraphy) AND ("+taY+" >= taArzeGoegraphy) OR" +
                                  "("+azX+" <= azTooleGoegraphy) AND ("+taX+" > azTooleGoegraphy) AND ("+azY+" <= azArzeGoegraphy) AND ("+taY+" > azArzeGoegraphy) OR" +
                                  "("+azX+" < taTooleGoegraphy) AND ("+taX+" >= taTooleGoegraphy) AND ("+azY+" < taArzeGoegraphy) AND ("+taY+" >= taArzeGoegraphy) OR" +
                                  "("+azX+" < taTooleGoegraphy) AND ("+taX+" >= taTooleGoegraphy) AND ("+azY+" <= azArzeGoegraphy) AND ("+taY+" > azArzeGoegraphy) OR" +
                                  "("+azX+" >= azTooleGoegraphy) AND ("+taX+" <= taTooleGoegraphy) AND ("+azY+" >= azArzeGoegraphy) AND ("+taY+" <= taArzeGoegraphy) ORDER BY mapLevel" );
        int i = 0;
		while( imgs.next() ) {
            i++;imgMap.put( new Img( imgs.getString( "fileName" ), imgs.getInt( "azTooleGoegraphy" ), imgs.getInt("taTooleGoegraphy"), imgs.getInt("azArzeGoegraphy"), imgs.getInt("taArzeGoegraphy"), imgs.getInt("mapLevel") ) );
        }
		System.out.println( i );
        imgs.close();
        imgs = null;
        return imgMap;
    }

    private MapLevel createSchema( ImageMap imgMap ) {
        MapLevel root = new MapLevel( 1, "naghsheh" );
        Set levels = imgMap.keySet();
        ArrayList levelList = new ArrayList();
		int index = 1;
        ArrayList temp = new ArrayList();
        boolean added = false;
        while( index <= levels.size() ) {
			//Integer ii = (Integer)items.next();
            ArrayList images = imgMap.get( new Integer(index) );			
            if( levelList.size() == 0 ) {
                root.setImgs( images );
                levelList.add( root );
                continue;
            }
            for( int i = 0; i < images.size(); i++ ) {
                Img image = (Img)images.get( i );
                for( int j = 0; j < levelList.size(); j++ ){
                    MapLevel l = (MapLevel)levelList.get( j );
                    temp.addAll( l.getSubLevels() );					
                    if( added )
                        continue;
                    added = l.createSubLevel( image );
                }
				added = false;
            }
            levelList.removeAll( levelList );
            levelList.addAll( temp );
			temp.removeAll( temp );
        }
        return root;
    }

    private String makeStructure( MapLevel root, javax.servlet.http.HttpServletRequest request ) throws IOException {
	String pdaDir = "/home/emdad/uploads/deploy2/pda.war/";
        String zipDir = pdaDir + "map.zip";
        ZipOutputStream zip = new ZipOutputStream( new FileOutputStream( zipDir ) );
        ArrayList levelList = new ArrayList();
        levelList.add( root );
        while( levelList.size() != 0 ) {
            MapLevel level = (MapLevel)levelList.get( levelList.size() - 1 );
            levelList.remove( level );
            createZipStructure( request, level, zip, zipDir );
            ArrayList subLevels = level.getSubLevels();
            for( int i = 0; i < subLevels.size(); i++ ) {
                MapLevel curLevel = (MapLevel)subLevels.get(i);
                if( curLevel.hasImage() ) {
                    levelList.add( curLevel );
				}
            }
        }
        zip.flush();
        zip.close();
        return "/pda/map.zip";
    }

    private void createZipStructure( javax.servlet.http.HttpServletRequest request, MapLevel level, ZipOutputStream zip, String zipDir ) throws IOException {
        final String mapWar = "/home/emdad/uploads/deploy2/map.war/";
        String fileName;
        for( int i = 0; i < level.getImgs().size(); i++ ) {
            fileName = ((Img)level.getImgs().get(i)).getName();
            zip.putNextEntry( new ZipEntry( level.getName() + File.separator + fileName ) );
            Util.copy( new FileInputStream( mapWar + fileName ), zip );
            zip.closeEntry();
        }
        zip.putNextEntry( new ZipEntry( level.getName() + File.separator + "index.html" ) );
		byte[] buf = new byte[1024];
		int len = 0;
		FileInputStream in = new FileInputStream( request.getRealPath( cur_dir + "map-top.jsp" ) );
		while ( (len = in.read( buf )) > 0 )
			zip.write( buf, 0, len );
		in.close();
        Img[][] imgs = level.toTableImgs();
        if( imgs == null ) {
            appendZip( zip, "<script>alert('There are no images for this coordination!!');history.back();</script>" );
        } else {
            for( int i = 0; i < imgs.length; i++ ) {
                appendZip( zip, "<tr>" );
                for( int j = 0; j < imgs[i].length; j++ ) {
                    if( imgs[i][j] != null )                        
                        appendZip( zip, "<td><a href='"+ level.getLinkFor( imgs[i][j].getName() )+"'><img id='img"+i+"_"+j+"' border='0' width='" + img_width + "' src='"+imgs[i][j].getName()+"'></a></td>" );
                }
                appendZip( zip, "</tr>" );
            }
        }
		in = new FileInputStream( request.getRealPath( cur_dir + "map-tail.jsp" ) );
		while ( (len = in.read( buf )) > 0 )
			zip.write( buf, 0, len );
		in.close();
        zip.closeEntry();
    }

    private void appendZip( ZipOutputStream zip, String input ) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( zip ) );
        bw.write( input );
		bw.flush();
		//bw.close();
    }
%>
<%
    String zipDir = "";
    try {
        zipDir = makeStructure( createSchema( readImages( request ) ), request );
    } catch ( Exception e ) {
        e.printStackTrace();
        out.println( "<h2 align=center>"+ e.getMessage() +"</h2>" );
        return;
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Naghshe</title>
</head>
<body>
<a href="<%=zipDir%>"><%=zipDir%></a>
</body>
</html>