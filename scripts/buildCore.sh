#!/bin/bash

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