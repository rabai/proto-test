Google Protobuf kép küldés tesztelése.

Ami kell hozzá:

Maven, Tomcat 8.0.x

Lépések:

1. Eclipse-ben hozzáadjuk a Tomcat szervert, elindítjuk.

2. A projektet beimportáljuk, az Eclipse lebuildeli (jobb esetben, ha mégsem: Alt+F5)

3. Hozzáadjuk a szerverhez a war-t

4. http://localhost:8080/protobuf-test/rest/protoTester/get_user címen hívhatjuk a fő logikát, amit a hu.inf.unideb.rest.ProtoTester tartalmaz

5. Eredményként a felhasználó home könyvtárában keletkezik egy másolat a resources-ben lévő képről (prototest/output.jpg)
