#!/bin/env python
import random

cmds =[ 'add', 'sold', 'bought', 'stock', 'inventory', 'remove' ]
opCnt = random.randrange(500000)
products = []

with open('products.txt', 'r') as f:
    lines = f.readlines()
    for line in lines:
        products.append(line.strip().rstrip())

with open("input_random.txt", "w") as f:
    for i in range(0, opCnt):
        op = random.randrange(len(cmds))
        cmdStr = cmds[op]
        # different cmds take different sets of parameters
        cmd = cmds[op]

        if cmd == 'add':
            product = products[random.randrange(len(products))]
            wholesale = round(random.random(), 2)
            resale = round(random.uniform(wholesale, 150), 2)
            qnty = random.randrange(100)
            cmdStr += " " + product + " " + str(qnty) + " " + str(wholesale) + " " + str(resale)
        elif cmd == 'sold' or cmd == 'bought':
            product = products[random.randrange(len(products))]
            qnty = random.randrange(100)
            cmdStr += ' ' + product + ' ' + str(qnty)
        elif cmd == 'stock' or cmd == 'remove':
            product = products[random.randrange(len(products))]
            cmdStr += ' ' + product

        cmdStr += '\n'
        f.write(cmdStr)
