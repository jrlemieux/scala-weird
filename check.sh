#!/bin/bash

javap -c 'target/scala-3.5.0/classes/com/playzone/Test1.class' > 1.log
javap -c 'target/scala-3.5.0/classes/com/playzone/Test1$$anon$1.class' > a1.log

javap -c 'target/scala-3.5.0/classes/com/playzone/Test2.class' > 2.log
javap -c 'target/scala-3.5.0/classes/com/playzone/Test2$$anon$1.class' > a2.log

sed 's/Test1/Test/g' 1.log  >1-normalized.log
sed 's/Test1/Test/g' a1.log >a1-normalized.log
sed 's/Test2/Test/g' 2.log  >2-normalized.log
sed 's/Test2/Test/g' a2.log >a2-normalized.log

echo "diff 1 vs 2"
diff 1-normalized.log 2-normalized.log

echo "diff a1 a2"
diff a1-normalized.log a2-normalized.log


