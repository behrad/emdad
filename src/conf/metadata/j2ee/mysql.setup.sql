set JBOSS_CLASSPATH=xxx/lib/jdbc/lib/mysql-connector-java-2.0.14-bin.jar

mysql -u root
GRANT ALL PRIVILEGES ON *.* TO nexuser@localhost identified by 'lexus';
create database sample;
show databases;
use sample;
select database();
show tables;
# xxx is the name of the table
describe xxx;

SET PASSWORD FOR nexuser@localhost = PASSWORD("lexus");

http:\\localhost:8080\jmx-console.  Select the 'service=3DJNDIView' =
under the
'jboss' heading.  Select the 'invoke' button under the java.lang.String
list() heading.  Anew page will be displayed - scroll down to the =
'Global
JNDI Namespace' heading and see if your been is deployed...

 * @ ejb :ejb - ref ejb-name="test/SequenceGenerator"
 *
 * @ ejb : transaction type="Required"
 *
 * @ jboss : finder-query name="findByName"
 *                     query="First_Name = {0} AND Last_Name = {1}"
 *
 * @ejb.value-object
 *      name="User"
 *      extends="com.objectj.sample.entity.BaseValueObject"
 *      match="*"
 * @ejb.value-object
 *      name="UserLight"
 *      extends="com.objectj.sample.entity.BaseValueObject"
 *      match="light"
 * @ejb.pk
 *      class="java.lang.Integer"
 * @jboss:table-name table-name="TestEntity"
