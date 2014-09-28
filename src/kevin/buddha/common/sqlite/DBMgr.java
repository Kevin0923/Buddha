package kevin.buddha.common.sqlite;

import kevin.buddha.constant.DBConstant;
import android.R.integer;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBMgr extends SQLiteOpenHelper {

    private static DBMgr dbhelper = null;

    public static DBMgr getInstens(Context context) {
        if (dbhelper == null) {
            dbhelper = new DBMgr(context);
        }
        return dbhelper;
    }

    private DBMgr(Context context) {
        super(context, DBConstant.SHARED_PATH, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 这张表采用二进制文件存储对象注意第二个字段我们将对象存取在这里面
        String sql_class_table = "create table if not exists classtable(_id integer primary key autoincrement,classtabledata text)";
        db.execSQL(sql_class_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

    }
}
