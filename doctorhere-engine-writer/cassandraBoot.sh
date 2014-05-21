echo ""
echo "[info] : creating cassandra schema"
echo ""

cqlsh -f src/main/resources/schema.cli

echo ""
echo "[info] : created cassandra schema"
echo ""

