import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class Main {
  static Scanner console = new Scanner(System.in);
  
  public static void main(String[] args) {
    try {
      System.out.println("Please enter your message to be encrypted: ");
      byte[] input = console.nextLine().getBytes();
      
      // Get input text to be encrypted.

      byte[] keyBytes = new byte[] {0x01, 0x23, 0x25, 0x67, (byte)0x89, (byte)0xab, (byte)0xcd, (byte)0xef};
      byte[] ivBytes = new byte[] {0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07};
      SecretKeySpec key = new SecretKeySpec(keyBytes,"DES");
      IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
      
      // Specifies the key and the parameters used for encryption and decryption.

      Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      
      // Initialises the cipher parameters.

      cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
      byte[] encrypted = cipher.doFinal(input);
      System.out.println("Encrypted message: " + encrypted);
      
      // Encrypts the input message using the parameters and outputs it.

      cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
      byte[] decrypted = cipher.doFinal(encrypted);
      System.out.println("Decrypted message: " + new String(decrypted));
      
      // Decrypts the input message using the parameters and outputs it.
      
    }
    catch (Exception ex){
      System.out.print("Error catched " + ex.getMessage());
      return;
    }
  }
}