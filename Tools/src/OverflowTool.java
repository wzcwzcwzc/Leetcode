public class OverflowTool {

    // 如何判断一个int是不是会overflow

    public static void main(String[] args) {

        int base = 1;
        String str = "123";
        int lastIndex = str.indexOf('3');
        // 首先需要定位base为该整数的倒数第二位
        // 出现overflow的情况要么就是比最大数字/10还大，要么就是等于最大数字/10但是最后一位大于7

        if (base > Integer.MAX_VALUE / 10 ||
                (base == Integer.MAX_VALUE / 10 && str.charAt(lastIndex) - '0' > 7)) {
            System.out.println("overflow");
        }
    }
}
