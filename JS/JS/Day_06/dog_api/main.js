/*
API là gì? Application Programming Interface(Giao diện lập trình ứng dựng)
API công cụ dùng kết nối (Trao đổi dữ liệu - JSON/XML) các ứng dụng hoặc thư viện với nhau.

Client - Server
Client gửi request(yêu cầu) -> Server
Server xử lý yêu cầu -> Response (phản hồi) cho Client
API: xử lý trung gian (tiếp nhận request, trả về Response)

Khách hàng (Client) - nhân viên(API) -> Bếp (Server)

API: URL - HTTP Method, (Dữ liệu gửi lên - option)
- URL : Xác định tài nguyên cần thao tác(resource)
- HTTP Method : Hành động đối với tài nguyên đấy là gì? (CRUD) 
- Create : Post 
- Read  : Get
- Update  : Put/Patch
- Delete : Delete

Users: 
    - Post : /api/users + request body
    - Get : /api/users, /api/users/1, /api/users/1/posts, /api/users?name=an&sort=asc
    - Put : /api/users/1
    - Delete : /api/users/1 
*/

// URL - GET: https://dog.ceo/api/breeds/image/random
//Cách 1: fetch API (build - in Javascript)
//Cách 2: axios (3rd - library)

const imageEL = document.querySelector("img")
//Promise + fetch
// const fetchImage = () => {
//     fetch("https://dog.ceo/api/breeds/image/random")
//         .then(res => {
//             console.log(res);

//             return res.json();
//         })
//         .then(res => {
//             console.log(res);
//             imageEL.src = res.message;
//         })
//         .catch(err => {
//             console.log(err);
//         })
// }

// Async Await + fetch
// const fetchImage = async () => {
//     try {
//         let res = await fetch("https://dog.ceo/api/breeds/image/random");
//         let resJson = await res.json();
//         console.log(resJson);
//         imageEL.src = resJson.message;
//     } catch (error) {
//         console.log(error);
//     }

// }

// Async Await + axios
const fetchImage = async () => {
    try {
        let res = await axios.get("https://dog.ceo/api/breeds/image/random");
        console.log(res);

        imageEL.src = res.data.message;
    } catch (error) {
        console.log(error);
    }

}

fetchImage();




