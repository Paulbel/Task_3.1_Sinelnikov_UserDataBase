package dao.impl;

public final class SQIDAOConstants {
    public static final String FIND_USER_BY_INITIALS_SURNAME = "SELECT * FROM info WHERE name =? AND surname = ?";
    public static final int FIND_USER_BY_INITIALS_NAME_INDEX = 1;
    public static final int FIND_USER_BY_INITIALS_SURNAME_INDEX = 2;
    public static final int USER_TABLE_NAME_COLUMN_INDEX = 1;
    public static final int USER_TABLE_SURNAME_COLUMN_INDEX = 2;
    public static final int USER_TABLE_PHONE_COLUMN_INDEX = 3;
    public static final int USER_TABLE_EMAIL_COLUMN_INDEX = 4;

    private SQIDAOConstants() {
    }
}
