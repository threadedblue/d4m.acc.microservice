package d4m.acc.microservice;

public class RowColRequest {

    
    private String row;
    private String col;
    private String tableName;

    public String getRow() {
        return row;
    }
    public void setRow(String row) {
        this.row = row;
    }
    public String getCol() {
        return col;
    }
    public void setCol(String col) {
        this.col = col;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    } 
}
