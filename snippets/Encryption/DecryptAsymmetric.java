import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class DecryptAsymmetric {

    private Cipher cipher;

    public DecryptAsymmetric(PrivateKey privateKey, File encryptedReceived, File decrypted, String algorithm) 
        throws IOException, GeneralSecurityException {

        this.cipher = Cipher.getInstance(algorithm);
        decryptFile(getFileInBytes(encryptedReceived), decrypted, privateKey);

    }

    public void decryptFile(byte[] input, File output, PrivateKey key) 
        throws IOException, GeneralSecurityException {

        this.cipher.init(Cipher.DECRYPT_MODE, key);
        writeToFile(output, this.cipher.doFinal(input));

    }

    private void writeToFile(File output, byte[] toWrite) 
        throws IllegalBlockSizeException, BadPaddingException, IOException{

        output.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(output);
        fos.write(toWrite);
        fos.flush();
        fos.close();

    }

    public byte[] getFileInBytes(File f) throws IOException{

        FileInputStream fis = new FileInputStream(f);
        byte[] fbytes = new byte[(int) f.length()];
        fis.read(fbytes);
        fis.close();
        return fbytes;

    }

}