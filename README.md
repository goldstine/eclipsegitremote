# shell脚本
## shell参数
+ $n(n为数字，$0代表该脚本名称，$1-$9代表第一到第九个参数，十以上的参数需要用大括号包含，如${10})
+ $#(获取所有输入参数的个数)
+ $*(代表命令行中所有的参数，$*把所有的参数都堪称一个整体),$@(这个命令也是代表命令行中的所有参数，不过是把每一个参数区分对待)
+ $?(最后一次执行的命令的返回状态，如果为0，证明上一个命令正确执行，如果这个值非0（具体是哪一个数值，由命令自己决定），则证明上一个命令执行不正确)
## shell运算符
$((运算式))或$[运算式]
expr +,-,\*,/,%   expr运算符之间要有空格
输出（2+3）*4 ：expr `expr 2 + 3` \* 4      s=$[(2+3)*4] echos $s
## shell 条件判断
[ condition ] (注意：condition前后要有空格)
注意：条件非空即为true，条件为空则为false [atguigu]返回true ，[]返回false
+ 常用判断条件
   + 两个整数之间比较
     = 字符串比较
     -lt 小于（less than）  -le小于等于（less equal）  -eq等于（equal） -gt大于（greater than）  -ge大于等于（greater equal） -ne不等于(not equal)
          例子：判断23是否小于32  [ 23 -lt 32 ]    查看结构 echo $? 返回值0 ，表示返回为true
   + 按照文件权限进行判断
   -r有读的权限（read）  -w有写的权限(write) -x有执行的权限（execute）
          例子：判断parameter.sh是否具有写权限   [ -w parameter.sh ]      echo $?
   + 按照文件类型进行判断
   -f 文件存在并且是一个常规的文件（file）
   -e 文件存在（exitstence） -d文件存在并是一个目录
          例子：/home/atguigu/cls.txt目录中的文件是否存在      [ -e /home/atguigu/cls.txt ]  echo $?
          
   多条件判断：&&表示前一条命令执行成功时，才执行后一条语句，||表示上一条命令失败后，才执行下一条命令
## shell if
```
if [ 条件判断式 ];then
  程序
fi
或者
if [ 条件判断式 ]
  then
    程序
fi
```
**注意：条件表达式与中括号之间必须要有空格**
** if后要有空格 **       elif
例子：输入一个数字，如果是1，则输出goldstine,如果是2 ，则输出liu，如果是其他，什么也不输出
```
#!/bin/bash
if [ $1 -eq 1 ];then
	echo "goldstine"
elif [ $1 -eq 2 ]
then
	echo "liu"
fi
```

## shell Case
例子：输入一个数字，如果是1，则输出banzhang,如果是2，则输出cls ，如果是其它，输出renyao
```
#!/bin/bash
case $1 in
1)
	echo "banzhang"
;;
2)
	echo "cls"
;;
*)
	echo "renyao"
;;
esac
```

## shell for
```
for (( 初始值;循环控制条件;变量变化 ))
  do
    程序
  done
例子：从1加到100
#!/bin/bash
s=0
for((i=1;i<=100;i++))
do
	s=$[$s+$i]
done

echo $s

第二种语法
for 变量 in 值1 值2 值3
  do
    程序
  done

#!/bin/bash

for i in $*
do
	echo "goldstine $i"
done

for j in $@
do
	echo "banzhang xihua $j"
done
输出结果：
goldstine as
goldstine wq
goldstine ewe
goldstine er
banzhang xihua as
banzhang xihua wq
banzhang xihua ewe
banzhang xihua er

如果对$* 和$@加上双引号，那么$*就是一个整体
#!/bin/bash

for i in "$*"
do
	echo "goldstine $i"
done

for j in "$@"
do
	echo "banzhang xihua $j"
done


输出结果：
goldstine er rt dw we
banzhang xihua er
banzhang xihua rt
banzhang xihua dw
banzhang xihua we
```

## while
```
while [ 条件表达式 ]
do 
  程序
done

例子：从1加到100
#!/bin/bash
s=0
i=1
while [ $i -le 100 ]
do
	s=$[$i+$s]
	i=$[$i+1]	
done

echo "$s"
```

## read 读取控制台输入
```
read(选项)(参数)
选项：
 -p:指定读取值时的提示符
 -t:指定读取值时的等待的时间（秒）
参数：
  变量：指定读取值的变量名
read -t 7 -p "enter you name in 7 seconds" NAME
echo $NAME
```

## baseName&DirName
```
函数
（1）系统函数
basename基本语法
basename [string/pathname] [suffix](basename命令会删掉所有的前缀，包括最后一个（‘/’）字符，然后将字符串显示出来)
suffix为后缀，如果suffix被指定了，basename会将pathname或string中的suffix去掉

例子：
1、截取该/home/atguigu/banzhang.txt路径的文件名称
basename /home/atguigu/banzhang.txt
输出：banzhang.txt
basename /home/atguigu/banzhang.txt .txt
输出：banzhang

dirname
dirname文件绝对路径（功能描述：从给定的包含绝对路径的文件名中去除文件名（非目录的部分），然后返回剩下的目录部分）
dirname /opt/data/goldstine.txt
输出 /opt/data
```
## 自定义函数
```
[ function ] funname[()]
{
  Action;
  [return int;]
}
funname
(1)必须在调用之前先声明函数
（2）函数返回值，只能通过$?系统变量获得，可以显示加；return 返回，如果不加，将以最后一条命令运行结果作为返回值


## cut

## sed

## awk

## sort
