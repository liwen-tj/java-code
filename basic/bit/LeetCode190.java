package basic.bit;

public class LeetCode190 {
  /**
   * Reverse bits of a given 32 bits unsigned integer.
   *
   * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
   * return 964176192 (represented in binary as00111001011110000010100101000000).
   *
   * Follow up:
   * If this function is called many times, how would you optimize it?
   * */

  // you need treat n as an unsigned value
  public static int reverseBits(int n) {
    int ans = 0;
    int bit = 0;
    while (n != 0) {
      ans =  (ans << 1) + (n & 1);
      n = n >>> 1;
      bit += 1;
    }
    for (int i = bit; i < 32; i++) {
      ans = ans << 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int r = LeetCode190.reverseBits(43261596);
    System.out.println(Integer.toBinaryString(43261596));
    System.out.println(Integer.toBinaryString(r));
    System.out.println(r);

    int res = LeetCode190.reverseBits(0b11111111111111111111111111111101);
    System.out.println(Integer.toBinaryString(res));

//    int x = 0b11111111111111111111111111111101;
//    int y = x >> 1;
//    int z = x >>> 3;
//    System.out.println(Integer.toBinaryString(x));
//    System.out.println(Integer.toBinaryString(y));
//    System.out.println(Integer.toBinaryString(z));
  }
}
