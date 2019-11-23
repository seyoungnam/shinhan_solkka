function callAPI() {
    let data = '{"userId":"girl2019"}'
    axios.post("http://127.0.0.1:8000/getCardData", JSON.parse(data))
    .then(resData => {
        console.log(resData.data);
        document.getElementById("api").innerHTML = JSON.stringify(resData.data);
    })
    .catch(err => {
        console.log(err.message);
    });
}