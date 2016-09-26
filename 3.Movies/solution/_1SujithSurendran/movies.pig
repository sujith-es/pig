register '/home/cloudera/MovieUDF.jar';

define ToMinSec p2.DurationConversion();

movie = LOAD '/user/cloudera/movies_data.csv' 
using PigStorage(',') AS
(
id:int,
name:chararray,
year:int,
rating:float,
duration:chararray
);

duration_conversion = foreach movie generate id, name,year,rating,ToMinSec($4);
dump duration_conversion;
