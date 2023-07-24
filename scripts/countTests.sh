#!/bin/bash

EXPECTED_CNT=10
TEST_CNT=$(ls ../tests | wc -l)

echo "Counting the number of tests in the tests directory"
if [ $TEST_CNT -lt $EXPECTED_CNT ]
then
    echo -e "\e[31mWARNING: Only $TEST_CNT tests found, expected at least $EXPECTED_CNT. You won't receive full credit unless the required number of tests are added!\e[39m"
    exit 1
fi
