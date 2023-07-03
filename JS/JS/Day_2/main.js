// ARRAY
// Khai báo array rỗng
let arr = [];

// Khai báo array
let number = [];

// int[] 3 -> [0, 0, 0]
// Interger[] 3 -> [null, null, null]
// Gán giá trị cho các phần tử của array thông qua chỉ số
number[0] = 1;
number[1] = "Duy Anh";
number[2] = true;
number[7] = 10;
console.log(number);

// Khai báo và khởi tạo giá trị array
 let  myArr = [1,2,3,4, true, false, "Nguyễn Văn A"];

// Dự đoán
let arr1 = [1,2,3];
let arr2 = [1,2,3];
let arr3 = [3,2,1];
let str = "1,2,3";

// arr1 == arr2; // false
// arr2 == arr3.reverse(); // false
// arr1 == arr3.sort(); // false
// arr1 == arr1.sort(); true
// arr1 == arr1.reverse(); // true
// arr2 == str; //true
// arr1 == str; // false
console.log()

// Các phương thức: pop(), push(), shift(), unshift,
//slice(), splice(),
// reverse(), sort(),
// indexOf, lastIndexOf, includes

const numbers = [4, 2, 6, 3, 7, 23, 34, 45];
console.log(numbers.sort((a,b) => a-b) );
console.log(numbers.sort((a,b) => b-a) );

numbers.forEach((e) => {
    console.log(e);
})

// Bài 1:
function max(numbers){
    let max = numbers[0];
    for (let index = 0; index < numbers.length; index++) {
        if (max < numbers[index]) {
            max = numbers[index];
        }
    }
    return max;
}
console.log(max(numbers))
// Bài 2:
function min(numbers){
    let min = numbers[0];
    for (let index = 0; index < numbers.length; index++) {
        if (min > numbers[index]) {
            min = numbers[index];
        }
    }
    return min;
}
console.log(min(numbers));
// Bài 3:
function bai3(arr){
    return arr.map((e) => e % 2)
}
console.log(bai3([4,2,5,6,2,7]));
// Bài 4:
function repeatString(str){
    let res = [];
    for (let index = 0; index < 10; index++) {
        res[index] = str;       
    }
    return res.join("");
}
console.log(repeatString("a"))
// Bài 5:
function repeatString1(str){
    let res = [];
    for (let index = 0; index < 10; index++) {
        res[index] = str;       
    }
    return res.join("-");
}
console.log(repeatString1("a"))
// Bài 6:
function isSymmetricString(string = ""){
    let res ="";
    for (let index = string.length-1; index = 0  ; index--) {
        res += string.charAt(i);
    }
    return res;
 }
console.log( )


// OBJECT
// Khởi tạo object rỗng
let obj = {}

// Khởi tạo object có dữ liệu (nên sử dụng)
let user = {
    name: "Nguyễn Văn A",
    age: 23,
    email: "abc@gmail.com",
    sayHello : function(){
        console.log("Hello");
    },
    eat(food){
        console.log("Eat " + food);
    }
}
console.log(user.name);
user.eat("Cơm")

// Hoặc (hạn chế sử dụng vì cách khai báo không tường mình)
let user1 = {}
user.name = "Nguyễn Văn A"
user.age = 23
user.email = "abc@gmail.com"

// Lấy giá trị của name trong user
let name = user.name
// Tương tự với age, email
let email = user.email
let age = user.age

// Ngoài ra có thể dùng cú pháp obj[key] để lấy giá trị
let name1 = user["name"]
let age1 = user["age"]
let email1 = user["email"]

// C1 : Sử dụng Object.keys
// Lấy ra mảng các keys của object user
let keys = Object.keys(user)
console.log(keys);

// Duyệt qua mảng các keys để in ra value tương ứng
for (let i = 0; i < keys.length; i++) {
    console.log(user[keys[i]]);
}

// Danh sách các sản phẩm có trong giỏ hàng
let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]


// 1. In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
// Tên - Giá - Thương Hiệu - Số lượng
// Ví dụ : OPPO Find X3 Pro - 19500000 - OPPO - 3
function findByBrand (arr, brand) {
    return arr.filter(e => e.brand == brand);
}
console.log(findByBrand(products,"Apple"))

// 2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng
// Tổng tiền mỗi sản phẩm = price * count
function sum(arr,price){
    
    
}
// 3. Tìm các sản phẩm của thuơng hiệu "Apple"

// 4. Tìm các sản phẩm có giá > 20000000

// 5. Tìm các sản phẩm có chữ "pro" trong tên (Không phân biệt hoa thường)

// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product

// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng

// 8. Sắp xếp giỏ hàng theo price tăng dần

// 9. Sắp xếp giỏ hàng theo count giảm dần

// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
