
function deleteProduct(url) {
    if (confirm("Bạn chắc chắn xóa?") === true) {
        fetch(url, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                alert("Xóa thành công!");
            else
                alert("Xóa thất bại!");
        });
    }
}