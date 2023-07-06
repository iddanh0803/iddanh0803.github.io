// Câu 1:
const para = document.createElement("para1")
para.id = "text";
para.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript."
para.style.color = "#777";
para.style.fontSize = "2rem";
document.body.appendChild(para);

// Câu 2:
const listItems = document.querySelectorAll('#myList li');

for (let i = 0; i < listItems.length; i++) {
  listItems[i].style.color = 'blue';
}

// Câu 3:
const list = document.getElementById("list");
    // thêm 3 thẻ <li>
    const li8 = document.createElement('li');
    li8.textContent = 'Item 8';
    list.appendChild(li8);
    
    const li9 = document.createElement('li');
    li9.textContent = 'Item 9';
    list.appendChild(li9);
    
    const li10 = document.createElement('li');
    li10.textContent = 'Item 10';
    list.appendChild(li10);
    // sửa nội dụng <li>1 thành màu đỏ
    const li1 = list.querySelector("li:first-child");
    li1.style.color = "red";
    // sửa background <li> 3 thành màu xanh
    const li3 = list.querySelector("li:nth-child(3)");
    li3.style.backgroundColor = "blue"
    // xóa thẻ <li> 4
    const li4 = list.querySelector("li:nth-child(4)");
    list.removeChild(li4);
    // thêm thẻ <li> mới thay thế cho thẻ <li> 4
    const liNew = document.createElement("li");
    liNew.textContent = "thẻ thay thế cho thẻ <li> 4";
    list.insertBefore(liNew, list.children[3]);