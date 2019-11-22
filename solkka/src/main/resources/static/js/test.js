function callAPI() {
    let data = '{"number":"910101-1******"}'
    axios.post("http://127.0.0.1:8000/accountList", JSON.parse(data))
    .then(resData => {
        console.log(resData.data);
        document.getElementById("api").innerHTML = JSON.stringify(resData.data);
    })
    .catch(err => {
        console.log(err.message);
    });
}