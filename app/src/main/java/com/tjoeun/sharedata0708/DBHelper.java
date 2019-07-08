package com.tjoeun.sharedata0708;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //생성자 - Context를 호출해서 상위 클래스의 생성자를 호출
    public DBHelper(Context context){
        super(context, "datadb", null, 1);

    }

    //처음 사용할 때 한번 호출되는 메소드
    @Override
    public void onCreate(SQLiteDatabase db){
        //테이블을 생성하고 데이터 초기화하는 작업
        //서버에 기본 데이터가 있으면 가져와서 저장
        String tableSql = "create table tb_data(" +
                "_id integer primary key autoincrement, " +
                "name text, phone text)";
        //SQL 실행
        db.execSQL(tableSql);
        db.execSQL("insert into tb_data(name, phone) " +
                "values('정유미', '01012345678')");
        db.execSQL("insert into tb_data(name, phone) " +
                "values('한지민', '01087654321')");
        db.execSQL("insert into tb_data(name, phone) " +
                "values('이성경', '01011112222')");
   }

   //데이터베이스 버전이 변경된경우 호출되는 메소드
   //기존 데이터를 삭제하고 다시 테이블을 생성
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table tb_data");
        onCreate(db);
    }

}
