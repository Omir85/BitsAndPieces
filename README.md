# BitsAndPieces
A group of snippets that I use frequently.

For SignCertificate (edited from https://www.youtube.com/watch?v=fQEhA79ifnI)

Create a certificate chain using keytool:
1. Create the keystore and the root certifying authority's certificate rootca first with the following command
keytool -genkey -v -alias rootca -keyalg RSA -keystore kstore

2. Create server's certifying authority's initial certificate CA
keytool -genkey -v -alias CA -keyalg RSA -keystore kstore

3. Sign CA with rootca using SignCertificate and store the new signed certificate as CAsigned
java SignCertificate kstore rootca CA CAsigned

4. Now export the new signed certificate to a file CAsigned.crt
keytool -export -alias CAsigned -keystore kstore -file CAsigned.crt

5. Display the signed certificate content
keytool -printcert -v -file CAsigned.crt

6. Create a server key
keytool -genkey -v -alias serverKey -keyalg RSA -keystore kstore

7. Sign CA with the server key using SignCertificate and store the new signed certificate as serverKeySigned
java SignCertificate kstore CA serverKey serverKeySigned

8. Export the signed certificate to its crt file
keytool -export -alias serverKeySigned -keystore kstore -file serverKeySigned.crt

9. Import back the signed certificate into the keystore
keytool -import -alias serverKey -keystore kstore -file serverKeySigned.crt

10. List all of the keystore entries
keytool -v -list -keystore kstore

11. Display the signed server key content
keytool -printcert -v -file serverKeySigned.crt
