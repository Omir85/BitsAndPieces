# BitsAndPieces
A group of snippets that I use frequently.

For SignCertificate:
Create a certificate chain using keytool 
1. Create the keystore and the root certifying authority's certificate rootca first with the following command
keytool -genkey -v -alias rootca -keyalg RSA -keystore kstore

2. Create server's certifying authority's initial certificate CA1 
keytool -genkey -v -alias CA1 -keyalg RSA -keystore kstore

3. Sign CA1 with rootCA using SignCertificate and store the new signed certificate as CA1signed
java SignCertificate kstore rootCA CA1 CA1signed

4. Now export the new signed certificate to a file CA1signed.crt 
keytool -export -alias CA1signed -keystore kstore -file CA1signed.crt

