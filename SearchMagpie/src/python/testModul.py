# coding=<utf-8>
'''
인코딩 필수!
Created on 2021. 11. 17

@author: smhrd
'''


from flask import Flask
app = Flask(__name__)

print('출력문 확인!~')

x = input('첫번째 숫자입력:')
y = input('두번째 숫자입력:')

print('두수의 합은:',x+y)


@app.route("/")
def hello():
    return "lol!!!!!!!!!!!!!!!!!!!!!!!!!!lollollololol!!!!!!!!!!!"

if __name__ == '__main__':
    app.run()
    

