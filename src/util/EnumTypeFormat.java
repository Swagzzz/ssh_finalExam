package util;

public class EnumTypeFormat {
    public static String formatSex(int sex) { //转换int类型性别为字符串
        String str = "";
        switch (sex) {
            case 0:
                str = "男";
                break;
            case 1:
                str = "女";
                break;
        }
        return str;
    }

    public static String formatRoleToStr(int role) {
        String str = "";
        switch (role) {
            case 0:
                str = "未审批";
                break;
            case 1:
                str = "审批";
                break;
        }
        return str;
    }
    public static String formatStateToStr(int state){
        String str = "";
        switch (state) {
            case 0:
                str = "在职";
                break;
            case 1:
                str = "不在职";
                break;
        }
        return str;
    }
}
