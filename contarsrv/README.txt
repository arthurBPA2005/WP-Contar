contarsrv - backend do projeto Contar (WAR para WildFly 26 / Java EE 8 + BlazeDS).

O cliente Flex fica em ../contarflx e e compilado pelo Flash Builder direto em
src/main/webapp (contarflx.swf, modulos/*.swf e RSLs). Esses arquivos sao gerados
e nao sao versionados (ver ../.gitignore).

To deploy it:
Run the maven goals "install wildfly:deploy"

To undeploy it:
Run the maven goals "wildfly:undeploy"

==========================

BlazeDS / Remoting:
- Endpoint AMF: /contarsrv/messagebroker/amf
- Destinations em src/main/webapp/WEB-INF/flex/remoting-config.xml
- BlazeDS 4.7.3+ so desserializa classes de uma whitelist (CVE-2017-5641). Se o cliente
  passar a ENVIAR objetos de dominio (ex.: Sistema), liberar o pacote em services-config.xml.

==========================

DataSource:
"src/main/resources/META-INF/persistence.xml" defines the persistence unit
"contarsrvPersistenceUnit", which uses the JakartaEE default database
(java:comp/DefaultDataSource = H2 em memoria no WildFly: os dados somem ao reiniciar).

In production environment, you should define a database in WildFly config and point to this database
in "persistence.xml".

==========================

Testing:
This sample is prepared for running integration tests with the Arquillian framework.

Three profiles are defined in pom.xml:
-"default": no integration tests are executed.
-"arq-remote": you have to start a WildFly server on your machine. The tests are executed by deploying
 the application to this server. Run: "clean verify -Parq-remote"
-"arq-managed": this requires the environment variable "JBOSS_HOME" to be set:
 the server found in this path is started and the tests are executed by deploying the application to it.
 Instead of using this environment variable, you can also define the path in "arquillian.xml".
 Run: "clean verify -Parq-managed"

The Arquillian test runner is configured with "src/test/resources/arquillian.xml".
The profile "arq-remote" uses the container qualifier "remote"; "arq-managed" uses "managed".
