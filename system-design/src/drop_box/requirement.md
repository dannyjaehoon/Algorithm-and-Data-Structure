Functional Requirements
- upload a file
- download a file
- automatically sync files across devices

out of scope
- roll own blob storage

Non-functional requirements(quality)
(cap theorem : consistency, availability and partition tolerance)
- availability >> consistency
- low latency upload and downloads (as low as possible)
- support large files as 50 gb 
  - resumable uploads
- high data integrity (sync accuracy)