"مستندات رخداد"		"فهرست مستندات رخداد"	6
mostanadatRokhdadId     java.lang.Integer       5       "شناسه مدرک"          *   @list  @sort  @details
rokhdadId               java.lang.String        20      "رخداد"               *   @list  @sort  @fk:rokhdad:rokhdadId
shomarehSanad           java.lang.String        20      "شماره سند"              @list  @sort 
tarikhSanad             java.sql.Date           10      "تاریخ سند"          
tarikhSabt              java.sql.Date           10      "تاریخ ثبت سند"   *
sharh                   java.lang.String        128     "شرح سند"    *          @farsi
nameParvande            java.lang.String        64     "نام پرونده"      *         
