const heading = document.getElementById("heading");
console.log(heading)

const heading1 = document.querySelector("#heading");
console.log(heading1)

// ? truy cập p1 p2 p3
const p1 = document.querySelector("p");
const p2 = document.querySelector(".para")
const p3 = document.querySelector("p:nth-of-type(3)")
console.log(p3)

const p5 = document.querySelector("div + ul > li:nth-of-type(3)");
const paraList = document.querySelectorAll("p");
console.log(paraList)

for (let index = 0; index < paraList.length; index++) {
    paraList[index].style.color = "red";
    paraList[index].style.backgroundColor = "black";
}

Array.from(paraList).map(e => console.log(e))

// Get/Set content
const ul1 = document.querySelector(".box ul");
console.log(ul1.innerHTML)
console.log(ul1.innerText)
console.log(ul1.textContent)

heading.innerHTML = "Xin chào";
heading.textContent = "<span>Hello</span>"

const socialMedia = [
    {
        label : "Google",
        link : "https://google.com"
    },
    {
        label : "Facebook",
        link : "https://facebook.com"
    },
    {
        label : "Instagram",
        link : "https://www.instagram.com/"
    }
]

const socialMediaEl = document.querySelector(".social-media")
const renderSocialMedia = list => {
    socialMediaEl.innerHTML ="";
    let html = "";
    list.forEach(e => {
        html +=` <a href = "${e.link}">${e.label}</a>`
    })
    socialMediaEl.innerHTML = html;
}
renderSocialMedia(socialMedia);

//Thêm phần tử
const btn = document.createElement("button");
btn.innerText = "Click Me";
console.log(btn);

document.body.appendChild(btn);

const btnCopy = btn.cloneNode(true);
document.body.prepend(btnCopy);

const btnCopy_1 = btn.cloneNode(true);
const scriptEl = document.querySelector("script")
document.body.insertBefore(btnCopy_1, scriptEl);

//Insert part2
p3.insertAdjacentHTML("afterend", `<input type = "text" placeholder="Enter name"/>`)
p1.insertAdjacentElement("beforebegin", btn.cloneNode(true))
//Xóa
document.body.removeChild(p1)
p2.parentElement.removeChild(p2)
//Thay thế
let newElement = document.createElement("h1")
newElement.innerText = "Xin chào các bạn";

// document.body.replaceChild(newElement, p3);