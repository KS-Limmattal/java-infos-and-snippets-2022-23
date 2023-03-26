import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class VerifySignature {

    public static void writeToFile(String path, byte[] key) throws IOException {

        File f = new File(path);
        f.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public static PublicKey getPublic(String filename, String algorithm) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance(algorithm);
        return kf.generatePublic(spec);

    }
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        File decryptedFile = new File("DecryptedFiles/decryptedFile");

        //calculate sha256 hash
        byte[] data = Files.readAllBytes(decryptedFile.toPath());
        byte[] hash = MessageDigest.getInstance("SHA-256").digest(data);
        String checksum = new BigInteger(1, hash).toString(16);
        System.out.println("SHA256 checksum: " + checksum);
        writeToFile("DecryptedFiles/sha256hash", hash);

        //generate signature (not using the generated hash from above)
        PublicKey publicKey = getPublic("KeyPair/publicKey_Alice", "RSA");
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initVerify(publicKey);
        privateSignature.update(Files.readAllBytes(decryptedFile.toPath()));

        byte[] signature = Files.readAllBytes(new File("EncryptedFiles/signature").toPath());
        boolean verification = privateSignature.verify(signature);
        System.out.println(verification ? "Signatures match" : "Signatures don't match");
    }
    
}
