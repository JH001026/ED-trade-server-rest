package com.ed_trade.ed_tradeserver_rest.database.uplink;

import com.ed_trade.ed_tradeserver_rest.database.QueryController;

public class JSONToSQL {
    private static String sql = "USE EDDB\n" +
            "\n" +
            "IF OBJECT_ID('EDDB.dbo.modules') IS NOT NULL\n" +
            "    DROP TABLE EDDB.dbo.modules\n" +
            "GO\n" +
            "\n" +
            "CREATE TABLE EDDB.dbo.modules\n" +
            "(\n" +
            "[id] INT NOT NULL,\n" +
            "[group_id] INT NOT NULL,\n" +
            "[class] INT NOT NULL,\n" +
            "[price] FLOAT,\n" +
            "[name] VARCHAR(100),\n" +
            "[ed_id] INT,\n" +
            "[ed_symbol] VARCHAR(100)\n" +
            ")\n" +
            "\n" +
            "Declare @JSON varchar(max)\n" +
            "\n" +
            "SELECT @JSON = BulkColumn\n" +
            "FROM OPENROWSET (BULK 'C:\\Users\\Jeroe\\IdeaProjects\\ED-trade-server-rest\\data\\json\\modules.json', SINGLE_CLOB) as j\n" +
            "\n" +
            "INSERT INTO EDDB.dbo.modules\n" +
            "(\n" +
            "[id],\n" +
            "[group_id],\n" +
            "[class],\n" +
            "[price],\n" +
            "[name],\n" +
            "[ed_id],\n" +
            "[ed_symbol]\n" +
            ")\n" +
            "SELECT * FROM OPENJSON (@JSON)\n" +
            "WITH(\n" +
            "[id] int,\n" +
            "[group_id] int,\n" +
            "[class] int,\n" +
            "[price] float,\n" +
            "[name] VARCHAR(100),\n" +
            "[ed_id] int,\n" +
            "[ed_symbol] VARCHAR(100)\n" +
            ") as Modules";



    public static void main(String[] args) {
        QueryController qc = new QueryController(sql);
        qc.executePlainSQL();

    }


}
