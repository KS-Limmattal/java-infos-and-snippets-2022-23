import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class GetKeysFromKeystore {

    public static void writeToFile(String path, byte[] key) throws IOException {

        File f = new File(path);
        f.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public static void main(String[] argv) throws NoSuchAlgorithmException, NoSuchProviderException, IOException,
            UnrecoverableKeyException, KeyStoreException, CertificateException {
        FileInputStream is = new FileInputStream("my_keystore.jks"); //TODO: Fill in correct parameters

        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(is, "storepw".toCharArray()); //TODO: Fill in correct parameters

        String alias = "mykeypair"; //TODO: Fill in correct parameters

        // Get certificate of public key
        Certificate cert = keystore.getCertificate(alias);

        // Get public key
        PublicKey publicKey = cert.getPublicKey();


        writeToFile("KeyPair/publicKey", publicKey.getEncoded());
        writeToFile("KeyPair/certificate.cer", cert.getEncoded());

        Key key = keystore.getKey(alias, "storepw".toCharArray()); //TODO: Fill in correct parameters
        if (key instanceof PrivateKey) {
            // Return a key pair (not used)
            new KeyPair(publicKey, (PrivateKey) key);
            writeToFile("KeyPair/privateKey", key.getEncoded());
        }
    }
}
