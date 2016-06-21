#!/usr/bin/python
# -*- coding: utf-8 -*-
import requests
icebreaker_url="http://localhost:8080/test/"

# Authorization
path = icebreaker_url + "api/user/login"
headers = {"Content-Type":"application/xml", "Accept":"application/xml"}

userId='admin'
passwd='password'
data = '<?xml version="1.0" encoding="utf-8" ?><login><userId>%s</userId><password>%s</password></login>' % (userId, passwd)

print "login: ", path
res = requests.post(path, data=data, headers=headers)
print res
print res.text
temp_token=res.text.split('\n')
token='Basic ' + temp_token[0][7:]
headers.update({'Authorization':token})
