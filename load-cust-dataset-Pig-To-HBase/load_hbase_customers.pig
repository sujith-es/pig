raw_data = LOAD 'hdfs:/user/cloudera/customer_data.csv' USING PigStorage(',') AS

(
custno:chararray,
firstname:chararray,
lastname:chararray,
age:int,
profession:chararray
);

dump raw_data;

STORE raw_data INTO 'hbase://customers' USING org.apache.pig.backend.hadoop.hbase.HBaseStorage('customers_data:custno,customers_data:firstname,customers_data:lastname,customers_data:age,customers_data:profession');
