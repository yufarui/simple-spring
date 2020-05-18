package yu;

import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import yu.config.HBaseUtils;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class HBaseTest {

    private static final String TABLE_NAME = "class";
    private static final String TEACHER = "teacher";
    private static final String STUDENT = "student";

    @Test
    public void createTable() {
        // 新建表
        List<String> columnFamilies = Arrays.asList(TEACHER, STUDENT);
        boolean table = HBaseUtils.createTable(TABLE_NAME, columnFamilies);
        System.out.println("表创建结果:" + table);
    }


    @Test
    public void insertData() {
        List<Pair<String, String>> pairs1 = Arrays.asList(new Pair<>("name", "Tom"),
                new Pair<>("age", "22"),
                new Pair<>("gender", "1"));
        HBaseUtils.putRow(TABLE_NAME, "rowKey1", STUDENT, pairs1);

        List<Pair<String, String>> pairs2 = Arrays.asList(new Pair<>("name", "Jack"),
                new Pair<>("age", "33"),
                new Pair<>("gender", "2"));
        HBaseUtils.putRow(TABLE_NAME, "rowKey2", STUDENT, pairs2);

        List<Pair<String, String>> pairs3 = Arrays.asList(new Pair<>("name", "Mike"),
                new Pair<>("age", "44"),
                new Pair<>("gender", "1"));
        HBaseUtils.putRow(TABLE_NAME, "rowKey3", STUDENT, pairs3);
    }


    @Test
    public void getRow() {
        Result result = HBaseUtils.getRow(TABLE_NAME, "rowKey1");
        System.out.println(result);
        if (result != null) {
            System.out.println(Bytes
                    .toString(result.getValue(Bytes.toBytes(STUDENT), Bytes.toBytes("name"))));
        }

    }

    @Test
    public void getCell() {
        String cell = HBaseUtils.getCell(TABLE_NAME, "rowKey2", STUDENT, "age");
        System.out.println("cell age :" + cell);

    }

    @Test
    public void getScanner() {
        ResultScanner scanner = HBaseUtils.getScanner(TABLE_NAME);
        if (scanner != null) {
            scanner.forEach(result -> System.out.println(Bytes.toString(result.getRow()) + "->" + Bytes
                    .toString(result.getValue(Bytes.toBytes(STUDENT), Bytes.toBytes("name")))));
            scanner.close();
        }
    }


    @Test
    public void getScannerWithFilter() {
        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
        SingleColumnValueFilter nameFilter = new SingleColumnValueFilter(Bytes.toBytes(STUDENT),
                Bytes.toBytes("name"), CompareOperator.EQUAL, Bytes.toBytes("Jack"));
        filterList.addFilter(nameFilter);
        ResultScanner scanner = HBaseUtils.getScanner(TABLE_NAME, filterList);
        if (scanner != null) {
            scanner.forEach(result -> System.out.println(Bytes.toString(result.getRow()) + "->" + Bytes
                    .toString(result.getValue(Bytes.toBytes(STUDENT), Bytes.toBytes("name")))));
            scanner.close();
        }
    }

    @Test
    public void deleteColumn() {
        boolean b = HBaseUtils.deleteColumn(TABLE_NAME, "rowKey2", STUDENT, "age");
        System.out.println("删除结果: " + b);
    }

    @Test
    public void deleteRow() {
        boolean b = HBaseUtils.deleteRow(TABLE_NAME, "rowKey2");
        System.out.println("删除结果: " + b);
    }

    @Test
    public void deleteTable() {
        boolean b = HBaseUtils.deleteTable(TABLE_NAME);
        System.out.println("删除结果: " + b);
    }

}
