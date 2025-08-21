# Dropbox System Design - Back of the Envelope Calculations

## 1. Assumptions
- Users : 500 M registered, 100M monthly active users
- Average file size : 1MB
- Files per active user : 10 files/month
- Read/Write ratio : Reads ~ 10 * writes
- replication factor : 3x (durability)


## 2. Storage Requirements
- Uploads per month : 100M * 10 = 1B files/month
- Storage : 1B * 1 MB = 1 PB/month
- with replication = 3 PB/month
- Annual storage : 12 * 3 pb = 36 PB/year

## 3. Bandwidth
- write 
  - 1B/month -> ~33M/day -> ~380/sec
  - 380 X 1mb -> 380MB/s = 3 Gbps
- Reads
  - 10 X writes = 3.8 GB/s = 30 Gbps

## 4. Requests Per Second (QPS)
- **Writes** ≈ 380/s
- **Reads** ≈ 3,800/s
- **Total QPS ≈ 4,200/s**
- Design for peak load: ~40k QPS (or total QPS / S)

