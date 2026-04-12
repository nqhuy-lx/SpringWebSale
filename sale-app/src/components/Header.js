import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Apis, { endpoints } from "../configs/Apis";
import { useEffect, useState } from "react";

const Header = () => {

    const [categories, setCategories] = useState([]);

    const loadCate = async () => {
        let res = await Apis.get(endpoints['categories'])
        setCategories(res.data);
    }

    useEffect(() => {
        loadCate();
    }, [])

    return(
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">Sale App</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="#home">Trang chu</Nav.Link>
                        <NavDropdown title="Danh muc" id="basic-nav-dropdown">
                            {categories.map(c => <NavDropdown.Item key={c.id} href="#action/3.1">{c.name}</NavDropdown.Item>)}
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default Header;