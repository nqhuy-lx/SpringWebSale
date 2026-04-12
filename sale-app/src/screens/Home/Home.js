import { useEffect, useState } from "react";
import Apis, { endpoints } from "../../configs/Apis";
import MySpiner from "../../components/MySpiner";
import { Button, Card, Col, Row } from "react-bootstrap";

const Home = () => {
    const [products, setProducts] = useState([])
    const [loading, setLoading] = useState([])

    const loadProducts = async () => {
        try {
            setLoading(true)
            let res = await Apis.get(endpoints['products'])
            setProducts(res.data)
        } catch (ex) {

        } finally {
            setLoading(false)
        }
    }

    useEffect(() => {
        loadProducts();
    }, [])

    return (
        <>
            <Row>
                {products.map((p) => (
                    <Col xs={6} md={3} key={p.id}>
                        <Card>
                            <Card.Img variant="top" src={p.image} />
                            <Card.Body className="d-flex flex-column">
                                <Card.Title>{p.name}</Card.Title>
                                <Card.Text>{p.price} VND</Card.Text>

                                <div className="mt-auto">
                                    <Button variant="danger" className="me-2">
                                        Order
                                    </Button>
                                    <Card.Link href={`/products/${p.id}`}>
                                        Detail
                                    </Card.Link>
                                </div>
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>
            {loading && <MySpiner />}
        </>
    )
}

export default Home;