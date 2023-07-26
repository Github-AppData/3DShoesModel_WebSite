/*
-변수-
var는 
var name;
console.log(name);  //undefined 
name = 'Mike';
이렇게 동작

var로 선언한 모든 변수는 최상위로 끌어올린 것처럼 동작 이를 호이스팅
하지만 콘솔은 undefined를 찍음. 왜냐면 선언만 호이스팅 되고 할당은 호이스팅 되지 않기 때문

호이스팅 : 스코프 내부 어디서든 변수 선언은 최상위에 선언된 것 처럼 행동

console.log(name);
var name = 'Mike';

let과 const도 호이스팅이 가능함. 하지만 Temporal Dead Zone 때문에 var처럼 동작을 안함.
이 TDZ 영역에 있는 변수들은 사용할 수 없음. let과 const는 TDZ영역 안에서 사용 불가. 값이 할당 되야 사용 가능.

let age = 30;
function showAge(){
    console.log(age);
    let age = 20;
}
showAge();

위와 같은 코드는 에러가 남.
호이스팅은 스코프 단위로 일어나기 때문에, 이 코드에서 스코프는 함수 내부.
함수 안에 있는 변수가 호이스팅을 일으킴.

var는 선언과 초기화가 동시에 됨.
let은 선언과 초기화단계가 분리되어서 진행.
const는 선언과 할당이 동시에 되어야함.

let name;
name = 'Mike';

var age;
age = 30;

const gender;
gender = 'male';

위 코드는 const부분에서 에러가 남

var는 함수스코프. let, const는 블록스코프.
블록스코프는 선언된 코드블록내에서만 유효하고, 외부에서는 접근 불가.

const age = 30;
if(age > 19){
    var txt = '성인';
}
console.log(txt);   //성인

하지만 var도 함수 내부에서 선언되면 바깥에서는 사용이 불가.

function add(num1, num2){
    var result = num1 + num2;
}
add(2, 3);
console.log(result);

-생성자 함수-
생성자 함수는 첫글자는 대문자로

function User(name, age){
    this.name = name;
    this.age = age;
}

let user1 = new User('Mike', 30);
let user2 = new User('Jane', 22);
let user3 = new User('Tom', 17);

메소드 추가

function User(name, age){
    this.name = name;
    this.age = age;
    this.sayName = function(){
        console.log(this.name);
    }
}
let User5 = new User('Han', 40);
User5.sayName();    //'Han'

function Item(title, price){
    //this = {};

    this.title = title;
    this.prict = price;
    this.showPrice = function(){
        console.log(`가격은 ${price}원 입니다.`);
    }

    //return this;
}
const item1 = new Item('인형', 3000);
const item2 = Item('가방', 4000);       //undefined
const item3 = new Item('지갑', 5000);

console.log(item1, item2, item3);

item3.showPrice();

-객체 메소드, 계산된 프로퍼티-

let a = 'age';
const user = {
    name : 'Mike',
    [a] : 30    // age : 30
}
변수 안에 있는 문자열이 그대로 들어감

const user = {
    [1+4] : 5,
    ["안녕"+"하세요"] : "Hello"
}
이런식으로 식 자체를 넣는것도 가능.

const user = {
    name : 'Mike',
    age : 30
}

const cloneUser = user;
이 경우에는 객체가 들어가는게 아니라 객체에 대한 참조값이 들어감.

동일하게 복제하려면 Object.assign 메소드 사용
const newUser = Object.assign({}, user);
여기서 빈 객체는 초기값. 뒤에 user는 빈 객체에 병합됨.
{ } + {name : 'Mike', age : 30 } 의 형태가 되어
{
    name : 'Mike',
    age : 30,
}
이 된다.

const newUser = Object.assign({}, user);

newUser.name='Tom';

console.log(user.name); //'Mike'

newUser != user
값을 바꿔도 바뀌지 않음.

Object.assign({gender:'male}, user);은 총 3개의 프로퍼티를 가지게 됨
gender : 'male',
name : 'Mike',
age : 30,

만약 병합을 하는데 키가 같다면 덮어쓰게 됨.

const user = {
    name : 'Mike'
}
const info1 = {
    age : 30,
}
const info2 = {
    gender : 'male',
}

Object.assign(user, info1, info2)
이처럼 3개도 합칠 수 있음

const user = {
    name : 'Mike',
    age : 30,
    gender : 'male',
}

Object.keys(user);
Object.keys는 객체의 키를 배열로 반환.
값들만 얻어오고 싶으면 Object.values(user); 사용
키와 값을 모두 배열로 반환하고 싶으면 Object.entries(user); 사용
반대기능은 Object.fromEntries(user);

let n = "name";
let a = "age";

const user = {
    [n] : "Mike",
    [a] : 30,
    [1+4]:5,
}
console.log(user);

function makeObj(key, val){
    return{
        [key] : val
    }
}

const obj = makeObj("성별", "male");
console.log(obj);
위처럼 어떤게 키가 될지 모를때 유용

const user = {
    name : "Mike",
    age : 30,
};

const result = Object.entries(user);

console.log(result);


let arr = [
    ['mon', '월'],
    ['tue', '화']
]

const result = Object.fromEntries(arr);

console.log(result);

-심볼-
심볼은 유일한 식별자를 만들 때 사용
const a = Symbol();
const b = Symbol();

a === b , a == b 는 모두 false가 나옴

심볼은 설명을 넣을 수 있음
const id = Symbol('id');
const user = {
    name : 'Mike',
    age : 30,
    [id] : 'myid'
}
Object.keys, values, entries, for in 모두 심볼은 건너 뜀

특정 객체의 원본 데이터는 건드리지 않고 추가 가능.

Symbol.for() : 전역 심볼
하나의 심볼만 보장받을 수 있음
없으면 만들고, 있으면 가져오기 때문
Symbol.for 메소드는 하나를 생성한 뒤 키를 통해 같은 Symbol을 공유

Object.getOwnPropertySymbols(user);를 사용하면 심볼을 볼 수 있음

//다른 개발자가 만들어 놓은 객체
const user = {
    name: "Mike",
    age: 30,
};

//내가 작업
//user.showName = function(){};
const showName = Symbol('show name');
user[showName] = function(){
    console.log(this.name);
}

user[showName]();

//사용자가 접속하면 보는 메세지
for (let key in user){
    console.log(`His ${key} is ${user[key]}.`);
}

-숫자 수학-
toString()은 숫자를 문자로 바꿔줌
이때 괄호 안에 숫자를 넣으면 그 숫자의 진법으로 바꿔줌

Math.PI;는 원주율을 구해줌

let num1 = 5.1;
let num2 = 5.7;

올림
Math.ceil(num1) //6
Math.ceil(num2) //6
내림
Math.floor(num1) //5
Math.floor(num2) //5
반올림
Math.round(num1) //5
Math.round(num2) //6

소수점 둘째자리까지 표현
let userRate = 30.1234;
Math.round(userRate * 100)/100  //30.12
혹은
userRate.toFixed(2);
0을 쓰면 정수만 남고 소수점 자릿수보다 큰 수를 넣으면 넘은만큼 0으로 채워줌
toFixed는 결과를 문자열로 반환. 때문에 반환받은 이후 넘버를 이용해 작업하는 경우 많음
Number(userRate.toFixed(2));

isNaN은 NaN인지 아닌지 판단
let x = Number('x');
x == NaN    //false
x === NaN   //false
NaN == NaN  //false

NaN은 오로지 isNaN을 통해서만 구분 가능
isNaN(x)    //true
isNaN(3)    //false

parseInt()는 문자열을 숫자로 반환
문자가 있어도 숫자가 있는 부분만 읽음. 하지만 숫자로 시작하지 않으면 NaN 반환
parseInt는 두번째 인수를 받아서 진수를 지정 가능

let redColor = 'f3'
parseInt(redColor, 16); //243

parseFloat()은 부동 소수점을 반환
Math.random()은 0부터 1까지의 숫자를 임의로 반환
1~100까지의 숫자를 뽑고 싶으면 Math.floor(Math.random() * 100) + 1

Math.max()
Math.min()
은 괄호 안의 숫자들 중 최대값과 최소값을 구할 수 있음.

Math.abs()는 절대값을 구해줌
Math.pow()는 제곱값을 구해줌
Math.sqrt()는 제곱근을 구해줌

-문자열 메소드-
` <- 은 여러줄을 포함할 수 있음
let desc = `오늘은 맑고 화창한
날씨가 계속 되겠습니다.
내일은 비소식이 있겠습니다.`;

length는 문자열의 길이를 구할 수 있음.

배열과 동일하게 문자열도 특정 위치에 접근 가능
let desc = '안녕하세요.';
desc[2] // '하'
하지만 배열과 다르게 한글자만 바꾸는것은 허용되지 않음.

toUperCase() / toLowerCase()
모든 영문자를 대문자와 소문자로 바꿔줌

.indexOf()는 문자를 인수로 받아 몇번째 위치하는지 알려줌. 0부터 셈
찾는문자가 없으면 -1을 내고 포함된 문자가 여러개라도 첫번째것만 알려줌.

if(desc.indexOf('Hi')){
    console.log('Hi가 포함된 문장입니다.');
}
주의해야하는게 위와 같은 코드는 indexOf가 0을 반환하고, if문에서 0은 false이기 때문에
console.log에 있는 문장을 볼 수 없음
그래서 항상 if(desc.indexOf('Hi') > -1)로 비교할것

.slice(n, m)는 n부터 m까지의 문자열을 반환 m은 없으면 문자열 끝가지, 양수면 그 숫자까지, 음수면 끝에서부터 셈
let desc = "abcdefg";

desc.slice(2)   //"cdefg"
desc.slice(0, 5)//"abcde"
desc.slice(2, -2)//"cde"

.substring(n, m)은 n과 m사이의 문자열 반환. 음수를 허용하지 않고 n과 m을 바꿔도 동작
.substr(n, m)은 n부터 시작해서 m개를 가져옴.
.trim()은 앞 뒤 공백을 제거함
.repeat(n) n번 반복

문자열도 비교가 가능함. "a" < "c"   //true
아스키 코드는 .codePointAt()이나 .fromCodePoint()를 사용하여 얻을 수 있음

let list = [
    "01. 들어가며",
    "02. JS의 역사",
    "03. 자료형",
    "04. 함수",
    "05. 배열",
];

let newList = [];

for (let i = 0; i < list.length; i++) {
    newList.push(
        list[i].slice(4)
    );  
}

console.log(newList);

//금칙어 : 콜라
function hasCola(str){
    if(str.indexOf('콜라') > -1){
        console.log('금칙어가 있습니다.');
    }else{
        console.log('통과')
    }
}

hasCola('와 사이다가 짱이야!')  // -1
hasCola('무슨소리, 콜라가 최고')
hasCola('콜라') // 0

// 금칙어 : 콜라
// includes
// 문자가 있으면 true
// 없으면 false 반환
function hasCola(str){
    if(str.includes('콜라')){
        console.log('금칙어가 있습니다.');
    }else{
        console.log('통과')
    }
}

hasCola('와 사이다가 짱이야!')  // -1
hasCola('무슨소리, 콜라가 최고')
hasCola('콜라') // 0

-배열-
push() : 뒤에 삽입
pop() : 뒤에 삭제
unshift() : 앞에 삽입
shift() : 앞에 삭제

.splice(n, m)은 특정 요소 지움  
let arr = [1, 2, 3, 4, 5];
arr.splice(1, 2);   // 2와 3이 지워짐

console.log(arr);   //[1, 4, 5]

.splice(n, m, x) : 특정 요소를 지우고 x자리에 오는걸 추가함
let arr = [1, 2, 3, 4, 5];
arr.splice(1, 3, 100, 200);

console.log(arr);   //[1, 100, 200, 5]

두번째 요소에 0을 넣으면 아무것도 지우지 않고 추가가 가능함.

.splice()는 삭제된 요소를 반환함.
let arr = [1, 2, 3, 4, 5];
let result = arr.splice(1, 2);

console.log(arr);   //[1, 4, 5]
console.log(result);//[2, 3]

.slice(n, m)은 n부터 m까지 반환
let arr = [1, 2, 3, 4, 5]
arr.slice(1, 4);    // [2, 3, 4]

let arr2 = arr.slice(); //괄호 안에 아무것도 안넣으면 배열이 복사됨
console.log(arr2);  //[1, 2, 3, 4, 5]

.concat()은 합쳐서 새배열로 변환
let arr = [1, 2];
arr.concat([3, 4]); //[1, 2, 3, 4]
arr.concat([3, 4], [5, 6]); //[1, 2, 3, 4, 5, 6]
arr.concat([3, 4], 5, 6); //[1, 2, 3, 4, 5, 6]

.forEach()는 배열 반복 가능


let arr = ['Mike', 'Tom', 'Jane'];

arr.forEach((name, index) => {
    console.log(`${index + 1}. ${name}`);
});

.indexOf()는 문자열의 indexOf와 사용법이 같음
발견하면 해당 요소의 인덱스를 발견하고 반환.
let arr = [1, 2, 3, 4, 5, 1, 2, 3];
arr.indexOf(3); //2
arr.indexOf(3, 3)//7
뒤에 인수를 넣으면 해당 위치부터 탐색

.lastIndexOf()는 끝에서부터 탐색
.includes()는 포함하는지 확인
.find() / .findIndex()는 찾는다는 의미는 동일하지만 함수를 연결 할 수 있음.
첫번째 true값을 반환하고 끝남. 없으면 undefined를 반환.

let arr = [1, 2, 3, 4, 5];
const result = arr.find((item) => {
    return item % 2 === 0;
});

console.log(result);

let userList = [
    { name : "Mike", age : 30 },
    { name : "Jane", age : 27 },
    { name : "Tom", age : 10 },
];

const result = userList.findIndex((user) => {
    if(user.age < 19){
        return true;
    }
    return false;
});

console.log(result);

.filter()는 find와 사용법은 동일하지만 만족하는 모든 요소를 배열로 변환 


let arr = [1, 2, 3, 4, 5, 6];
const result = arr.filter((item) => {
    return item % 2 === 0;
});

console.log(result);

.reverse()는 배열을 역순으로 재정렬함
.map()은 함수를 받아 특정 기능을 시행하고 새로운 배열을 반환

let userList = [
    { name : "Mike", age : 30 },
    { name : "Jane", age : 27 },
    { name : "Tom", age : 10 },
];

let newUserList = userList.map((user, index) => {
    return Object.assign({}, user, {
        id : index + 1,
        isAdult : user.age > 19,
    });
});

console.log(newUserList);
console.log(userList);


let arr = ['안녕', '나는', '철수야'];
let result = arr.join('-');    //join은 배열을 합쳐줌. 인수는 배열을 합칠때의 구분자임
console.log(result);


const users = 'Mike,Jane,Tom,Tony';
const result = users.split(',');    //split은 구분자를 기준으로 문자열을 나눠 배열에 넣어줌

console.log(result);

let user = {
    name : 'Mike',
    age : 30,
}

let userLIst = ['Mike', 'Tom', 'Jane'];
console.log(typeof user)
console.log(typeof userLIst)

console.log(Array.isArray(user))
console.log(Array.isArray(userLIst))

.sort()는 배열 재정렬. 배열 자체가 정렬됨


let arr = [1, 5, 4, 2, 3];

arr.sort();

console.log(arr);

let arr = [27, 8, 5, 13];

arr.sort();

console.log(arr);   //[13, 27, 5, 8] 문자열을 기준으로 정렬을 해서 1과 2로 시작하는 13과 27이 먼저 정렬

let arr = [27, 8, 5, 13];

arr.sort((a, b) =>{
    console.log(a, b);
    return a-b;
});

console.log(arr); 

.reduce()는 배열을 돌면서 원하는 작업을 하고 최종값 반환
(누적 계산값, 현재값) => {return 계산값};


//배열의 모든 수 합치기
let arr = [1, 2, 3, 4, 5];

//for, for of, forEach

const result = arr.reduce((prev, cur) => {
    return prev + cur;
}, 100)

console.log(result);

let userList = [
    { name : "Mike", age : 30 },
    { name : "Jane", age : 27 },
    { name : "Tom", age : 10 },
    { name : "Sue", age : 26 },
    { name : "Harry", age : 3 },
    { name : "Steve", age : 60 },
];

let result = userList.reduce((prev, cur) => {
    if(cur.name.length === 3){
        prev.push(cur.name);
    }
    return prev;
}, []);

console.log(result);

-구조 분해 할당-
배열이나 객체의 속성을 분해해서 그 값을 변수에 담을 수 있게 하는 표현식

배열구조분해
let [x, y] = [1, 2]
console.log(x); //1
console.log(y); //2


let users = ['Mike', 'Tom', 'Jane'];
let [user1, user2, user3] = users;

let user1 = users[0];
let user2 = users[1];
let user3 = users[2];

console.log(user1);
console.log(user2);
console.log(user3);

let [a=3, b=4, c=5] = [1, 2];   //기본값이 없으면 c에 undefined가 들어가기 때문에 기본값을 줘서 미연에 방지

let [user1, , user2] = ['Mike', 'Tom', 'Jane', 'Tony'];
빈칸으로 비워두면 반환받지 않고 넘어갈 수 있음

let a = 1;
let b = 2;
일반적으로 두 변수의 값을 바꾸려면 변수를 하나 더 할당해서 바꿔야 하지만 구조분해로 바꿔치기 가능
[a, b] = [b, a];

객체도 구조분해가 가능
let user = {name : 'Mike', age : 30};
let {name, age} = user; //이 코드는 let name = user.name; let age = user.age; 와 같음
                          한가지 다른점은 순서를 상관하지 않아도 된다는 점임
console.log(name);  //'Mike'
console.log(age);   //30

새로운 변수 이름으로 할당 가능
let {name : userName, age : userAge} = user;

객체 분해에도 기본값 지정 가능

-나머지 매개변수, 전개 구문-
... 점 3개로 사용

자바스크립트에서 함수에 인수에는 개수 제한이 없음
function showName(name){
    console.log(name);
}
showName('Mike');   //'Mike'
showName('Mike','Tom'); //?

arguments
함수로 넘어온 모든 인수에 접근 가능
함수 내에서 이용 가능한 지역 변수
length / index 가 있음
Array 형태의 객체
배열의 내장 메서드 없음

function showName(name){
    console.log(arguments.length);
    console.log(arguments[0]);
    console.log(arguments[1]);
}
showName('Mike', 'Tom');
//2
//'Mike'
//'Tom'

나머지 매개변수
function showName(...names){
    console.log(names);
}
showName(); //[]
showName('Mike');   //['Mike']
showName('Mike', 'Tom');    //['Mike', 'Tom']
나머지 매개변수는 정해지지 않은 인수의 갯수를 배열로 나타내줌

function add(...numbers){
    let result = numbers.reduce((prev, cur) => prev + cur);
    console.log(result);
}
add(1, 2, 3);
add(1, 2, 3, 4, 5, 6, 7 ,8 ,9, 10);

//나머지 매개변수는 항상 마지막에 위치해야함
function User(name, age, ...skills){
    this.name = name;
    this.age = age;
    this.skills = skills
}

const user1 = new User('Mike', 30, 'html', 'css');
const user2 = new User('Tom', 30, 'html', 'css');
const user3 = new User('Jane', 30, 'css');

console.log(user1);
console.log(user2);
console.log(user3);

전개구문
let arr1 = [1, 2, 3];
let arr2 = [4, 5, 6];

let result = [0, ...arr1, ...arr2, 7, 8, 9];
console.log(result);    //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

let arr = [1, 2, 3];
let arr2 = [...arr];    //[1, 2, 3]

let user = {name : 'Mike', age : 30};
let user2 = {...user};

user2.name = 'Tom';

console.log(user.name);     //'Mike'
console.log(user2.name);    //'Tom'


let arr1 = [1, 2, 3];
let arr2 = [4, 5, 6];

// arr2.reverse().forEach(num => {
//     arr1.unshift(num)
// })

arr1 = [...arr2, ...arr1];

console.log(arr1);

let user = {name : 'Mike'};
let info = {age : 30};
let fe = ['JS', 'React'];
let lang = ['Korean', 'English'];

// user = Object.assign({}, user, info, {
//     skills : [],
// });

// fe.forEach(item =>{
//     user.skills.push(item);
// })
// lang.forEach(item =>{
//     user.skills.push(item);
// })

user = {
    ...user,
    ...info,
    skills : [...fe, ...lang],
};

console.log(user);

-클로저-
자바스크립트는 어휘적 환경을 가짐
함수는 변수와 다르게 바로 초기화 됨
전역 Lexical환경과 함수에서 만들어진 내부 Lexical환경 존재

function makeAdder(x){  //makeAdder Lexical환경 생성       참조 2
    return function(y){ //익명함수 LExical환경 생성         참조 1
        return x + y;
    }
}

const add3 = makeAdder(3);  //add3은 전역 Lexical환경에 들어감  참조 3
console.log(add3(2));
클로저는 함수와 렉시컬 환경의 조합
함수가 생성될 당시의 외부 변수를 기억
생성 이후에도 계속 접근 가능

function makeCounter(){
    let num = 0;

    return function(){
        return num++;
    }
}

let counter = makeCounter();

console.log(counter()); //0
console.log(counter()); //1
console.log(counter()); //2

-setTimeout / setInterval-
일정시간 지난 후 함수 실행 / 일정 시간 간격으로 함수를 반복

function fn(){
    console.log(3)
}
setTimeout(fn, 3000);
 ->
setTimeout(function(){
    console.log(3)
}, 3000);

function showName(name){
    console.log(name);
}
setTimeout(showName, 3000, 'Mike');

clearTimeout();을 사용하면 스케줄링 취소 가능

function showName(name){
    console.log(name);
}
setInterval(showName, 3000, 'Mike');

딜레이타임을 0으로 줘도 바로 실행되지는 않음
이유는 현재 실행중인 스크립트가 종료된 이후 스케줄링 함수를 실행하기 때문

let num = 0;
function showTime(){
    console.log(`안녕하세요. 접속하신지 ${num++}초가 지났습니다.`);
    if(num > 5){
        clearInterval(tId);
    }
}
const tId = setInterval(showTime, 1000);

-call, apply, bind-
함수 호출 방식과 관계없이 this를 지정할 수 있음

call메서드는 모든 함수에서 사용할 수 있으며, this의 특정값으로 지정할 수 있음

const mike = {
    name : 'MIke',
};

const tom = {
    name : 'Tom',
};

function showThisName(){
    console.log(this.name); //<- this는 윈도우를 가르킴
}

showThisName();
showThisName.call(mike);    //함수를 호출하면서 콜을 사용하고 디스로 사용할 객체를 넘기면 해당 함수가 주어진 객체의 메소드인것처럼 사용 가능
showThisName.call(tom);

const mike = {
    name : 'MIke',
};

const tom = {
    name : 'Tom',
};

function showThisName(){
    console.log(this.name); //<- this는 윈도우를 가르킴
}

function update(birthYear, occupation){
    this.birthYear = birthYear;
    this.occupation = occupation;
}

update.call(mike, 1999, 'singer')
update.call(tom, 2002, 'singer')
console.log(mike);

apply는 함수 매개변수를 처리하는 방법을 제외하면 call과 완전히 같음
call은 일반적인 함수오 ㅏ마찬가지로 매개변수를 직접 받지만, apply는 매개변수를 배열로 받음

const mike = {
    name : 'MIke',
};

const tom = {
    name : 'Tom',
};

function showThisName(){
    console.log(this.name); //<- this는 윈도우를 가르킴
}

function update(birthYear, occupation){
    this.birthYear = birthYear;
    this.occupation = occupation;
}

update.apply(mike, [1999, 'singer'])
update.apply(tom, [2002, 'singer'])
console.log(mike);
console.log(tom);

const nums = [3, 10, 1, 6, 4]

const minNum = Math.min.apply(null, nums);
// const minNum = Math.min(...nums);
const maxNum = Math.max.call(null, ...nums);
// const maxNum = Math.max(...nums);

console.log(minNum);
console.log(maxNum);

bind는 함수의 this값을 영구히 바꿀 수 있음

const mike = {
    name : 'Mike',
};

function update(birthYear, occupation){
    this.birthYear = birthYear;
    this.occupation = occupation;
}

const updateMike = update.bind(mike);

updateMike(1980, 'police');
console.log(mike);

const user = {
    name : 'Mike',
    showName : function(){
        console.log(`hello, ${this.name}`);
    },
};

user.showName();

let fn = user.showName;
fn.call(user);
fn.apply(user);
let boundFn = fn.bind(user);
boundFn();

-상속, prototype-

const car = {
    wheels : 4,
    drive(){
        console.log('drive');
    },
};

const bmw = {
    color : 'red',
    navigation: 1,

};

const benz = {
    color: 'black',

};


bmw.__proto__ = car;

const x5 = {
    color : 'white',
    name : 'x5',
}

x5.__proto = bmw;

hasOwnProperty는 객체가 가지고 있는 프로퍼티만 반환함

// const car = {
//     wheels : 4,
//     drive(){
//         console.log('drive');
//     },
// };

const Bmw = function(color){
    this.color = color;
};

const x5 = new Bmw('red');
const z4 = new Bmw('blue');

Bmw.prototype.wheels = 4;
Bmw.prototype.drive = function(){
    console.log('drive...');
};

Bmw.prototype.navaigation = 1;
Bmw.prototype.stop = function(){
    console.log('STOP!');
};

// x5.__proto__ = car;
// z4.__proto__ = car;

-클래스-

const User = function(name, age){
    this.name = name;
    this.age  = age;
    this.showName = function(){
        console.log(this.name);
    };
};

const mike = new User('Mike', 30);

class User2{
    constructor(name, age){
        this.name = name;
        this.age = age;
    }
    showName(){
        console.log(this.name)
    }
}

const tom = new User2('tom', 10);
//클래스는 new 없이 실행 불가

클래스에서 상속은 extends를 사용

class Car{
    constructor(color){
        this.color = color;
        this.wheels=4;
    }
    drive(){
        console.log('drive...');
    }
    stop(){
        console.log('STOP');
    }
}

class Bmw extends Car{
    park(){
        console.log('PARK');
    }
}

const z4 = new Bmw('blue');

오버라이딩

class Car{
    constructor(color){
        this.color = color;
        this.wheels=4;
    }
    drive(){
        console.log('drive...');
    }
    stop(){
        console.log('STOP');
    }
}

class Bmw extends Car{
    park(){
        console.log('PARK');
    }
    stop(){
        super.stop();
        console.log('OFF');
    }
}

const z4 = new Bmw('blue');


//extends로 만든 클래스는 빈 객체를 만드는 순서를 건너뜀. 때문에 this를 쓰려면 super사용해야함

class Car{
    constructor(color){
        this.color = color;
        this.wheels=4;
    }
    drive(){
        console.log('drive...');
    }
    stop(){
        console.log('STOP');
    }
}

class Bmw extends Car{
    constructor(color){
        super(color);
        this.navigation = 1;
    }
    park(){
        console.log('PARK');
    }

}

const z4 = new Bmw('blue');

-Promise-
const pr = new Promise((resolve, reject) => {
    //code
});
resolve는 성공, reject는 실패했을때 실행되는 함수
어떤 일이 완료된 후 실행되는것을 콜백함수라 함
then을 이용하면 resolve와 reject를 처리 가능
첫번째 인수는 이행되었을때 실행. 두번째 인수는 거절되었을때 실행
then 말고도 catch 와 finally 사용 가능
catch는 오류가 났을 때, finally는 항상 실행

const pr = new Promise((resolve, reject) => {
    setTimeout(()=>{
        resolve('OK');
    }, 1000)
});

console.log('시작');
pr.then((result) => {
    console.log(result);
})
    .catch((err)=>{
        console.log(err);
    })
    .finally(() => {
        console.log('끝')
    });

Promise.all은 모두 보여주고 Promise.race는 먼저 들어오면 보여줌

const f1 = () => {
    return new Promise((res, rej) => {
        setTimeout(() => {
            res('1번');
        }, 1000);
    });
};

const f2 = () => {
    return new Promise((res, rej) => {
        setTimeout(() => {
            res('2번');
        }, 1000);
    });
};

const f3 = () => {
    return new Promise((res, rej) => {
        setTimeout(() => {
            res('3번');
        }, 1000);
    });
};

f1()
    .then((res_ => f2(res)))
    .then((res_ => f3(res)))
    .then((res_ => console.log(res)))
    .catch(console.log)
    .finally(console.log('끝'))


-async, await-


async function getName(){
    //return Promise.resolve('tom');
    throw new Error('err');
}    

getName().then(name => {
    console.log(name);
})


async function getName(name){
    return new Promise((resolve, reject) =>{
        setTimeout(() => {
            resolve(name);
        }, 1000);
    });

}   

async function showName(){
    const result = await getName('Mike');   //await오른쪽에는 Promise코드가 옴
}
console.log('시작');
showName();

const f1 = () => {
    return new Promise((res, rej) => {
        setTimeout(() => {
            res('1번');
        }, 1000);
    });
};

const f2 = () => {
    return new Promise((res, rej) => {
        setTimeout(() => {
            //res('2번');
            rej(new Error('err'));
        }, 1000);
    });
};

const f3 = () => {
    return new Promise((res, rej) => {
        setTimeout(() => {
            res('3번');
        }, 1000);
    });
};
async function order(){
    try{
        const result = await Promise.all([f1(), f2(), f3()]);
        console.log(result);
    }catch (e) {
        console.log(e);
    }

    console.log('종료');
}

-Generator-
함수의 실행을 중간에 멈췄다가 재개할 수 있는 기능

function* fn() {
    console.log(1);
    yield1;
    console.log(2);
    yield2;
    console.log(3);
    console.log(4);
    yield3;
    return 'finish';
}
const a = fn();

Generator는 next(), return(), throw() 코드 존재
Generator는 iterable임
iterable
 - Symbol.iteratror 메서드가 있다.
 - Symbol.iterator는 iterator를 반환해야 한다

iterator
 - next메서드를 가진다
 - next메서드는 value와 done속성을 가진 객체를 반환한다.
 - 작업이 끝나면 done은 true가 된다
Generator는 iterable 객체임

function fn(){
    const num1 = yield '첫번쨰 숫자를 입력해주세요';
    console.log(num1);

    const num2 = yield '두번째 숫자를 입력해주세요';
    console.log(num2);

    return num1 + num2;
}

const a = fn();

Generator는 값을 미리 만들어 두지 않음

function* fn(){
    let index = 0;
    while(true){
        yield index++;   
    }
}

const a = fn();

function* gen1(){
    yield 'w';
    yield 'o';
    yield 'r';
    yield 'l';
    yield 'd';
}

function* gen2(){
    yield 'Hello';
    yield* gen1();
    yield '!';
}
*/