console.log("Hello world");
// alert("Hello");
// Khai báo biến và không gán giá trị cho biến
let age;
age = 35;

// Khai báo biến và gán giá trị cho biến
let email = "hien@techmaster.vn"

const PI = 3.14;
// PI = 4 --> lỗi
// kiểu dữ liệu nguyên thủy trong java: int, float, double, long, short, boolean, byte, char.
// JS: number, string, boolean, null, undefined, symbol (ES6)
const status = true;
// const name = null;
const userId = undefined;
//ES6 Template string
let name = "Bùi Hiên"
let year = 1997

function getAge(year){
    return 2023-year;
}

console.log(`Xin chào các bạn, mình tên là ${name}. Năm nay ${2023 - year} tuổi`);
console.log("Xin chào các bạn,mình tên là " + name + ". Năm nay " + (2023 - year) +" tuổi");
console.log(1 + "0") // "10"
console.log(1 - "0");// 1
console.log(2 * "2");// 4
console.log("9" / 3);// 3
console.log("2" * "3");// 6
console.log("2" * "3a"); // NaN = Not a Number

//Method & Function
//Method được định nghĩa trong class, đi liền với đối tượng

// Cách 1: Regular function 
function sum(a, b){
    let username = "Nguyễn Văn A";
    console.log(username);
    console.log(username.length);
    return a + b;
}


// Cách 2: Function expression // Default Parameter (ES6)
const sum1 = function(a = 20, b = 30){
    return a + b;
}

// Cách 3: Arrow function (ES6)
// const sum2 = (a, b) => {
//     return a + b;
// }
const sum2 = (a, b) =>  a + b;

console.log(sum(3,4));
console.log(sum1(10)) // a = 10, b = undefined => a + b = 10 + undefined = NaN
console.log(sum1()) // a = undefined, b = undefined => a + b = undefined + undefined = NaN

// console.log(username);
{
     fullName = "Trần Văn B";
    console.log(fullName.concat("abc"));
}
console.log(fullName);
// Bài 1
function repeat(str = "a" ){
    let val = ""
    for(let a = 1; a <=10; a++ ){
        val += str;
       
    }
    return val;
}
console.log(repeat(str = "a" ))
// Bài 2
function repeat1(str = "a"){
    let ans ="";
    for(let a = 1; a <=10; a++ ){
      ans = ans + str + "-";
    //   if(a == 10){
    //     ans = ans + str;
    //   } 
    }
    return ans.slice(0, ans.length-1);
}
console.log(repeat1("a"))
// console.log(repeat1("a"))
// Bài 3
function repeat2(str = "a", n){
    let res = "";
    for(let i = 0; i<n; i++){
        res = res + str + "-";
          if(i == n-1){
        res = res + str;
      } 
    }
    return res;
}
console.log(repeat2("a", 5))