(function () {

    document.getElementById('form-register').addEventListener('submit', (event) => {
        fetch('/api/member', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                'memberId': document.getElementById('memberId').value,
                'memberPw': document.getElementById('memberPw').value,
                'authId': 'USER'
            })
        })
        .then((res) => {
            console.log('success')
        })
        .catch((err) => {
            console.error('error occured')
        })
    })
})();