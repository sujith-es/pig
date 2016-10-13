This program is to load customer data from Pig to HBase

Step 1. First download dataset (I downloaded in /home/cloudera) and load in to HDFS (I have use cloudera)

	$ hadoop fs -put /home/cloudera/customer_data.csv /user/cloudera

Step 2. Open a new terminal and start hbase shell

	$ hbase shell

Step 3. Create a table ‘customers’ with column family ‘customers_data’

	hbase(main):001:0> create 'customers', 'customers_data'

Step 4. List the tables

	hbase(main):002:0> list

Step 5. Exit from HBase shell

	hbase(main):003:0> exit

Step 6. In terminal with linux prompt $ export below jar file

	$ export PIG_CLASSPath=/usr/lib/hbase/hbase.jar 

Step 7. Run the PIG Script (load_hbase_customers.pig)

	$ load_hbase_customers.pig

Step 8: Enter HBase shell and verify the data in the ‘customers’ table.

hbase(main):001:0> scan 'customers'
OR
hbase(main):001:0> count 'customers'


