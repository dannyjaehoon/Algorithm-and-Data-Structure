# Core Entities
- file (raw bytes)
- file metadata - file name, Id, mime type, size, etc
- users

# File Service APIs

## 1. POST /files
- **Request Body**: File metadata (fileId, fileName, size, mimeType, ownerId, etc.)
- **Action**:
  - Client sends metadata to the File Service.
  - File Service registers the file and requests a pre-signed URL from Blob Storage.
- **Response**: `200 OK` with a pre-signed URL for uploading chunks.

---

## 2. PUT /files/{presignedUrl}
- **Request Body**: File chunk (raw bytes).
- **Action**:
  - Client uploads a chunk directly to Blob Storage using the pre-signed URL.
  - Blob Storage stores the raw bytes of the chunk.
- **Response**: `200 OK` confirming successful chunk upload.

---

## 3. PATCH /files
- **Request Body**: Partial file metadata (chunkId, status, updates, s3Link).
- **Action**:
  - Client notifies File Service that a chunk has been uploaded.
  - File Service updates the metadata record (e.g., chunk status = "uploaded").
- **Response**: `200 OK` acknowledging metadata update.

---

## 4. GET /files/:fileId
- **Action**:
  - Client requests a file by its ID.
  - File Service returns file metadata (fileName, size, ownerId, chunk list, s3Links, status, etc.).
  - Client can download the file directly from Blob Storage using the provided links.
- **Response**: `200 OK` with file & metadata.

---

## 5. GET /changes?since={timestamp}
- **Action**:
  - Client queries the service for recent file changes since a given timestamp.
  - Service responds with a list of updated file IDs.
  - For each fileId, the client fetches metadata via `GET /files/:fileId` and updates its local copy.
- **Response**: `200 OK` with list of changed fileIds.

---

## ✅ End-to-End Flow
1. **POST /files** → Client announces new file, receives pre-signed URL.
2. **PUT /files/{presignedUrl}** → Client uploads chunks to Blob Storage.
3. **PATCH /files** → Client updates File Service with chunk status.
4. **GET /files/:fileId** → Other clients fetch file & metadata.
5. **GET /changes** → Clients sync and stay up to date.


