fetch("/v1/api/account/login", {
  headers: { "Content-Type": "application/json;charset=utf-8" },
  method: "POST",
  body: JSON.stringify({
    loginId: "alpha@example.com",
    loginPw: "password111",
  })
}).then(res => console.log(res.status));