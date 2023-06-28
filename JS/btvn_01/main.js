// Bài 1:
function calculateFactorial(n){
    let res = 1;
    for(let i = 0; i <n ; i++){
        res *=i;
    }
    return res;
}
console.log(calculateFactorial(5))
// Bài 2:
function reverseString(str="hello"){
    let res = "";
    for(let i = str.length-1; i = 0; i--){
        res  += str.charAt(i);
    }
    return res;
}
console.log(reverseString("hello"));
// Bài 3:
function translate(){
    let code = "";
    switch (code){
        case  "0086":{
            console.log("你好")
            break
        }
       case "0084":{
        console.log("Xin chào")
        break
       }
       case "001":{
        console.log("Hello")
        break
       }
    }
}
// Bài 4:
function subString(str = "xinchaocacbandenvoiTechmaster"){
    if(str.length > 15 ){
        str.substring(0,10);
    }else return str
    
}
console.log(subString("xinchaocacbandenvoiTechmaster"))

