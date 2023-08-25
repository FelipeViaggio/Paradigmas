module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ = Qua

capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua name capacity delay) = capacity

delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua name capacity delay) = delay

-- Pruebas

q1 = newQ "A" 10 0.1
q2 = newQ "B" 20 0.2

capacityQtest = capacityQ q1

delayQtest = delayQ q2

lista = [
         capacityQtest == 10,
         capacityQtest /= 20,
         delayQtest == 0.2,
         delayQtest /= 0.1
         ]