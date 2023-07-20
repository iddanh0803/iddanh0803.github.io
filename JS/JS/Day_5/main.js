const users = [
    {
        name: 'John Doe',
        quote: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
        image: 'https://randomuser.me/api/portraits/men/41.jpg',
        color: '#d3cce3'
    },
    {
        name: 'Jane Smith',
        quote: 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
        image: 'https://randomuser.me/api/portraits/women/50.jpg',
        color: '#e9e4f0'
    },
    {
        name: 'David Williams',
        quote: 'Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
        image: 'https://randomuser.me/api/portraits/women/22.jpg',
        color: '#f0e4e9'
    },
    {
        name: 'Emily Brown',
        quote: 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.',
        image: 'https://randomuser.me/api/portraits/women/76.jpg',
        color: '#cce3d3'
    },
    {
        name: 'Michael Johnson',
        quote: 'Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
        image: 'https://randomuser.me/api/portraits/men/17.jpg',
        color: '#e4f0e9'
    },
];

const testimonialsContainer = document.querySelector('.testimonials-container');
const text = document.querySelector('.text');
const name = document.querySelector('.name');
const authors = document.querySelectorAll('.author');
const avtiveAuthor = 0;

function renderImage(){
    image.innerHTML ="";
    let html = "";
    list.forEach(e => {
        html +=`<div class="author"><img src="${infor.image}" alt=""></div>`
    })
    image.innerHTML = html;
}
renderImage()
function renderActiveAuthor(index){
    // xoa selected
    let selectedAuthor = document.querySelector("selected")
            if(selectedAuthor){
                selectedAuthor.classList.remove('selected');
            }
    //active author
    const infor = users[index];
    text.textContent = infor.quote;
    name.textContent = infor.name;
    
}