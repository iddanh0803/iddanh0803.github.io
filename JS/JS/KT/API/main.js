const postsBtn = document.getElementById('postsBtn');
const photosBtn = document.getElementById('photosBtn');
const albumsBtn = document.getElementById('albumsBtn');
const dataList = document.getElementById('dataList');

// Đường dẫn tới API
const postsUrl = 'https://jsonplaceholder.typicode.com/posts';
const photosUrl = 'https://jsonplaceholder.typicode.com/photos';
const albumsUrl = 'https://jsonplaceholder.typicode.com/albums';

// Hàm để lấy dữ liệu từ API và hiển thị
function fetchData(url) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            dataList.innerHTML = ''; // Xóa các mục hiện tại trong danh sách

            // Hiển thị các mục dữ liệu
            data.forEach(item => {
                const listItem = document.createElement('li');
                listItem.textContent = item.title;
                dataList.appendChild(listItem);
            });
        })
        .catch(error => {
            console.log('Error:', error);
        });
}

// Sự kiện click cho các button
postsBtn.addEventListener('click', function () {
    postsBtn.classList.add('active');
    photosBtn.classList.remove('active');
    albumsBtn.classList.remove('active');
    fetchData(postsUrl);
});

photosBtn.addEventListener('click', function () {
    postsBtn.classList.remove('active');
    photosBtn.classList.add('active');
    albumsBtn.classList.remove('active');
    fetchData(photosUrl);
});

albumsBtn.addEventListener('click', function () {
    postsBtn.classList.remove('active');
    photosBtn.classList.remove('active');
    albumsBtn.classList.add('active');
    fetchData(albumsUrl);
});

// Mặc định hiển thị danh sách bài viết khi trang được tải
fetchData(postsUrl);