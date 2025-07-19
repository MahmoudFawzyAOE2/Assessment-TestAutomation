package testData;

import java.util.List;

public class TestData {

    public static String AdminUserName = "Admin";
    public static String AdminPassword = "admin123";
    public static String AdminRole = "Admin";
    public static String AdminStatus = "Enabled";
    public static int AdminPageIndex = 0;
    public static int NumberOfAdmins = 1;

    public static List<String> AdminData = List.of(
            AdminRole,
            AdminUserName,
            AdminStatus
    );
}


