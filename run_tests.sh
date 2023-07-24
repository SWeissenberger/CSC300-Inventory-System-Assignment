#!/bin/bash

RET_VAL=0

echo -e '\e[32m[+] cleaning tests folder\e[39m'
rm -f tests/*.class

echo -e '\e[32m[+] checking number of unit tests provided\e[39m'
cd scripts
./countTests.sh
if [ $? -ne 0 ]; then
    RET_VAL=1
fi
cd ../

# compile all of the test files
echo -e '\e[32m[+] building core files\e[39m'
for x in $(ls -1 *.java);
do
    echo -e "\e[36mbuilding $x \e[39m"
    ./javac-ds $x;
    if [ $? -ne 0 ]; then
        echo -e "\e[31mERROR: failed to build a core file( $x ), exiting\e[39m"
        exit 1
    fi
done

# now run all of the class files
echo -e "\e[32m[+] building  and running test files\e[39m"
for x in $(ls -1 tests/*.java);
do
    cp $x .
    JFILE=${x#"tests/"}
    echo -e "\e[36mbuilding $JFILE \e[39m"
    ./javac-ds $JFILE;
    if [ $? -ne 0 ]; then
        echo -e "\e[31mERROR: failed to build test file: $JFILE, skipping test\e[39m"
        RET_VAL=1
    else
        CFILE=${JFILE%".java"}
        echo -e "\e[93mrunning $CFILE \e[39m"
        ./java-ds $CFILE
        if [ $? -ne 0 ]; then
            echo -e "\e[31mERROR: $CFILE returned a failure\e[39m"
            RET_VAL=1
        fi
        rm $CFILE.class
    fi
    rm $JFILE
done

exit $RET_VAL

