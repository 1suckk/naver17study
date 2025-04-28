let obj1 = {"name":"lee","age":23,"addr":"Seoul"};
console.log(obj1.name);
console.log(obj1.age);
console.log(obj1.addr);

//오브젝트 통으로 대입
let obj2 = obj1;

let {name, age}=obj2;
console.log("name="+name);
console.log("age"+age);

//함수
let f1 = ({name="수지",age=20}={})=>console.log("이름="+name+",age="+age);

//호출
f1(); //초기값으로 지정한 수지, 20이 각각 이름과 나이로 나온다
f1(obj2.name);
f1(obj1);