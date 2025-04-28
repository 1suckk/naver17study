//배열의 펼침 연산자
let arr = [3,5,7];

let f1=(a,b)=>console.log(a,b);

//기존 방법
function f2(a, b)
{
    console.log(a,b);
}

f1(arr[0],arr[1]);
f1(...arr); //펼침연산자, 맨앞에서 두 개가 추출된다

let arr1=[1,2];
let arr2=[11,33,55,66];
let arr3=[10, ...arr1, 8, ...arr2]; //10 1 2 8 11 33 55 66
console.log(arr3.length);
console.log(arr3);